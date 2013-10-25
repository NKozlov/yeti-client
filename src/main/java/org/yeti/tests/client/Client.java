/*
 * Copyright (c) 2008-2013
 * LANIT
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * LANIT and its licensors, if any.
 *
 * $Id$
 */
package org.yeti.tests.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * todo Document type Client
 */
public class Client {

    public static void main(String[] args) {

        try {

            Socket clientSocket = null;

            // 127.0.0.1 - IP где запущен Server, 1234 - порт

            clientSocket = new Socket("127.0.0.1", 8080);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

            String fuser, fserver;

            out = new PrintWriter(clientSocket.getOutputStream(), true);

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while ((fuser = inu.readLine()) != null) {

                out.println(fuser);

                //                fserver = in.readLine();

                //                System.out.println(fserver);

                if (fuser.equalsIgnoreCase("close")) {

                    break;
                }

                if (fuser.equalsIgnoreCase("exit")) {

                    break;
                }
            }

            out.close();

            in.close();

            inu.close();

            clientSocket.close();
            System.out.println("Close connection");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
