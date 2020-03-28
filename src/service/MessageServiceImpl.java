package service;

import model.Message;
import model.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.ExcelOperation.ExcelRead;
import static util.ExcelOperation.ExcelWrite;

public class MessageServiceImpl implements MessageService {

    private static final String EXCELPATH = "E:\\ThePhoneBook\\src\\resource\\ThePhoneBook.xls";
    @Override
    public boolean addMessage(Message message){
       List<Map<Integer,String>> records = new ArrayList<>();
       try{
           records = ExcelRead(EXCELPATH);
           for(Map<Integer,String> record:records){                         //重复输入同一个号码,返回false
               if(record.get(2).equals(message.getPhoneNum())&&record.get(1).equals(message.getName())){
                   return false;
               }
           }

           int id = records.size();
           Map<Integer,String>newRecord = new HashMap<>();
           newRecord.put(0, ""+id);
           newRecord.put(1, ""+message.getName());
           newRecord.put(2, ""+message.getPhoneNum());
           newRecord.put(3, ""+message.getType().getCode());
           newRecord.put(4, ""+message.getEmail());
           newRecord.put(5, ""+message.getQqNum());
           newRecord.put(6, ""+message.getRemark());
           records.add(newRecord);
           ExcelWrite(EXCELPATH,records);
           return true;

       } catch (Exception e) {
           e.printStackTrace();
       }
        return false;
    }

    @Override
    public List<Message> getMessageByName(String name) {
        List<Map<Integer,String>> records;
        List<Message> returnMessage = new ArrayList<>();

        try{
            records = ExcelRead(EXCELPATH);
            for(Map<Integer,String> record:records){
                if(record.containsValue(name)){
                    Message message = new Message(Integer.parseInt( record.get(0) ),
                            record.get(1),
                             record.get(2) ,
                            Type.values()[Integer.parseInt( record.get(3))] ,
                            record.get(4),
                            record.get(5),
                            record.get(6));
                    returnMessage.add(message);
                }
            }
        return returnMessage;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Message> getMessageByType(int type) {
        List<Map<Integer,String>> records;
        List<Message> returnMessage = new ArrayList<>();
        try{
            records = ExcelRead(EXCELPATH);
            for(Map<Integer,String> record:records){
                if (record.get(3).contains("分组"))
                    continue;
                if(Integer.parseInt(record.get(3)) == type){
                    Message message = new Message(Integer.parseInt( record.get(0) ),
                            record.get(1),
                            record.get(2) ,
                            Type.values()[Integer.parseInt( record.get(3))] ,
                            record.get(4),
                            record.get(5),
                            record.get(6));
                    returnMessage.add(message);
                }
            }
            return returnMessage;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Message> getAllMessage() {
        List<Map<Integer,String>> records;
        List<Message> returnMessage = new ArrayList<>();
        try{
            records = ExcelRead(EXCELPATH);
            for(Map<Integer,String> record:records){
                if (record.get(3).contains("分组"))
                    continue;
                    Message message = new Message(Integer.parseInt( record.get(0) ),
                            record.get(1),
                            record.get(2) ,
                            Type.values()[Integer.parseInt( record.get(3))] ,
                            record.get(4),
                            record.get(5),
                            record.get(6));
                    returnMessage.add(message);
            }
            return returnMessage;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMessage(String name,int key,String value){          //key为修改的项目的编号（根据定义的顺序,0开始）value为要修改的值
        List<Map<Integer,String>> records;
        try{
            records = ExcelRead(EXCELPATH);

            for(Map<Integer,String> record:records){
                if(record.get(1).equals(name)){
                    record.put(key,value);                         //如果输入的是type，值应该是0,1,2
                }
            }

            ExcelWrite(EXCELPATH,records);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMessage(String phoneNum) {
        List<Map<Integer,String>> records;
        try{
            int deleteID = 1000;
            records = ExcelRead(EXCELPATH);
            for(Map<Integer,String> record:records){
                if(record.get(2).equals((phoneNum))){
                    deleteID = Integer.parseInt( record.get(0)) ;//记录被删除的数据的编号
                    records.remove(record);
                    break;
                }
            }
            for(Map<Integer,String> record:records){            //调整后续编号
                if(record.get(0).equals(("编号"))){
                    continue;
                }
                if(Integer.parseInt( record.get(0))>deleteID){
                    record.put(0,""+(Integer.parseInt( record.get(0))-1));
                }
            }
            ExcelWrite(EXCELPATH,records);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
