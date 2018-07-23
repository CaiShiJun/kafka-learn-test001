package org.github.caishijun.test;

import org.github.caishijun.util.SendMessageToKafka2;

public class TestClazz {

    public static void main(String[] args){
        SendMessageToKafka2.sendMessageToKafka();
        SendMessageToKafka2.asynchronousSendMessage();
        SendMessageToKafka2.synchronousSendMessage();
    }

}
