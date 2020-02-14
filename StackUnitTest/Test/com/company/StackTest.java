package com.company;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Student> studentStack;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        studentStack = new Stack<>(12);
        try {
            studentStack.push(new Student("Bob","Ram",18));
            studentStack.push(new Student("John","Bush",17));
            studentStack.push(new Student("Jozef","Gregorsky",21));
            studentStack.push(new Student("Rabi","Filly",15));
            studentStack.push(new Student("Hol","Rothy",16));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        studentStack = null;
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        System.out.println(studentStack.getSize());
        int size = studentStack.getSize();
        for (int a=0;a<size;a++){
            try {
                System.out.println(a);
                studentStack.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assertEquals(true,studentStack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isFull() {
        for (int a=studentStack.getSize();a<studentStack.getCapacity();a++){
            try {
                studentStack.push(new Student("Bob","Ram",18));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        assertEquals(true,studentStack.isFull());
    }

    @org.junit.jupiter.api.Test
    void push() {
        int prevSize = studentStack.getSize();
        Student student = new Student("Adam","Ivan",40);
        try {
            studentStack.push(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(prevSize+1,studentStack.getSize());
        assertEquals(student,studentStack.top());
    }

    @org.junit.jupiter.api.Test
    void pop() {
        int prevSize = studentStack.getSize();
        Student student = studentStack.top();
        try {
            studentStack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(prevSize-1,studentStack.getSize());
        assertNotEquals(student,studentStack.top());
    }

    @org.junit.jupiter.api.Test
    void top() {
        Student student = new Student("Adam","Ivan",40);
        try {
            studentStack.push(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(student,studentStack.top());
    }

    @org.junit.jupiter.api.Test
    void topAndPop() {
        Student student = new Student("Adam","Ivan",40);
        try {
            studentStack.push(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(student,studentStack.topAndPop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void getSize() {
        assertEquals(5,studentStack.getSize());
    }

    @org.junit.jupiter.api.Test
    void getCapacity() {
        assertEquals(12,studentStack.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void empty() {
        studentStack.empty();
        assertEquals(true,studentStack.isEmpty());
    }

    //stack can be created with negative capacity
}