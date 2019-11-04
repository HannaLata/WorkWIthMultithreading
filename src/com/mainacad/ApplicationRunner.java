package com.mainacad;

import com.mainacad.helper.ConnectionInfoHelper;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.multithreads.MultithreadWrapper;

import java.util.*;
import java.util.logging.Logger;

public class ApplicationRunner {

    private static final Logger LOGGER =
            Logger.getLogger(ApplicationRunner.class.getName());


    public static void main(String[] args) {


        List<String> connectionIpList = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<>();


        for (int i = 1; i <= 100; i++) {
            ConnectionInfo connectionInfo = ConnectionInfoHelper.getRandomConnectionInfo();
            MultithreadWrapper multithreadWrapper = new MultithreadWrapper("thread" + i, connectionInfo, connectionIpList);

            threads.add(multithreadWrapper);

            multithreadWrapper.start();
        }

    }

}


