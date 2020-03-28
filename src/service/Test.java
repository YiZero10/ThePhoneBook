//package service;
//
//import model.Message;
//import model.Type;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Test {
//    public static void main(String[] args){
//        Message testMessage = new Message(
//                "tr12",
//                "532214444",
//                Type.BUSINESS,
//                "111048739@qq.com",
//                "1119048739",
//                "无");
//        List<Message> testList = new ArrayList<>();
//
//        MessageService service = new MessageServiceImpl();
//        service.addMessage(testMessage);
//        System.out.println("增加完成！");
////
////        testList = service.getMessageByName("4");
////        System.out.println(testList.get(0).getQqNum());
////
////        testList = service.getMessageByType(2);
////        System.out.println(testList.get(0).getQqNum());
////
////        service.updateMessage("3",1,"1");
////        testList = service.getMessageByName("1");
////        System.out.println(testList.get(0).getName());
////
//        service.deleteMessage("5");
//    }
//}
