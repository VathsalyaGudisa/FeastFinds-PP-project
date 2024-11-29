/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.feastfinds;


import java.util.Scanner;

public class FeastFinds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to FeastFinds!");

        // You can instantiate your other classes here
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
        FinalPage finalPage = new FinalPage();
        FoodBookingPage foodBookingPage = new FoodBookingPage();
        LoginSignupPage loginSignupPage = new LoginSignupPage();

        // Use your classes as needed
    }

    public static class OrderSuccessPage {
        // OrderSuccessPage class code here
    }

    public static class FinalPage {
        // FinalPage class code here
    }

    public static class FoodBookingPage {
        // FoodBookingPage class code here
    }

    public static class LoginSignupPage {
        // LoginSignupPage class code here
    }
}
