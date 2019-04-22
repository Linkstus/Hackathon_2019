package application;

/*
    Course Number: CS 4345
    Semester/Year: Spring(2019)
    Assignment Id: Assignment 3
    Names: James Jackson, Johnnie Oldfield
*/

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
  // Server has port and a set of names and handlers
  private static int port;
  private ArrayList<String> names = new ArrayList<>();
  private ArrayList<ClientHandler> threads = new ArrayList<>();
  private static int serverStatus = 0;

  public Server() {}
  
  public void addToThreadsList(ClientHandler name) {
	  threads.add(name);
  }
  
  // Add user name to list
  public void addName(String userName) {
    names.add(userName);
  }

  // Remove user's name and client handler
  public void removeUser(String name, ClientHandler user) {
    try {
      names.remove(name);
      threads.remove(user);
    } catch (Exception e) {
      System.out.println("Error removing user.");
    }
  }

  // Broadcast message to all users
  public void broadcast(String message, ClientHandler user) {
    for (ClientHandler handler : threads) {
      if (handler != user) {
        handler.sendMessage(message);
      }
    }
  }

  // Send message to specific user
  public void whisper(String message, ClientHandler user) {
    // System.out.println(user + user.getName());
    user.sendMessage(message);
  }

  // Get name list
  public ArrayList<String> getNames() {
    return this.names;
  }

  // Get handler list
  public ArrayList<ClientHandler> getHandlers() {
    return this.threads;
  }
  
  public static void serverIsOn() {
	  serverStatus = 1;
  }
  
  public int getOnStatus() {
	  return serverStatus; 
  }
}