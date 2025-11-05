# OOP Scenario Based Explanation with Real World Examples (Java)

This document explains OOP Principles through real world practical scenarios and shows where which principle is used and why. Each scenario also contains beginner friendly code examples.

---

## 1) PAYMENT SYSTEM (UPI / Card)
### Where which principle is used?
- **Encapsulation** → Card number / UPI ID should be protected (private)
- **Abstraction** → Pay() hides internal gateway logic
- **Polymorphism** → pay() same, output different for Card, UPI

### Detailed Example
```java
abstract class Payment { abstract void pay(double amount); }
class CardPayment extends Payment {
    private String cardNumber;
    CardPayment(String num){ this.cardNumber=num; }
    void pay(double amount){ System.out.println("Paid via Card: "+amount); }
}
class UpiPayment extends Payment {
    private String upiId;
    UpiPayment(String id){ this.upiId=id; }
    void pay(double amount){ System.out.println("Paid via UPI: "+amount); }
}
```

---

## 2) Vehicle Rental (ZoomCar)
### Where used?
- **Inheritance** → Cars & Bikes share vehicle structure
- **Polymorphism** → rent() different depending vehicle

### Example
```java
class Vehicle{ int baseRent; Vehicle(int r){baseRent=r;} }
class Car extends Vehicle{Car(){super(1000);} }
class Bike extends Vehicle{Bike(){super(350);} }
```

---

## 3) Notification System (Email/SMS)
### Where used?
- **Polymorphism** → send() behaves different
- **Abstraction** → user does not know how sms/email internal works

### Example
```java
interface Notifier{ void sendMessage(String msg); }
class EmailNotifier implements Notifier{ public void sendMessage(String msg){} }
class SmsNotifier implements Notifier{ public void sendMessage(String msg){} }
```

---

## 4) ATM Machine
### Where used?
- **Encapsulation** → balance private
- **Abstraction** → complex banking logic hidden

### Example
```java
class Account{
 private double balance;
 public void deposit(double amt){ balance+=amt; }
 public void withdraw(double amt){ if(amt<=balance) balance-=amt; }
}
```

---

## 5) Logger System (File Logger / Cloud Logger)
### Where used?
- **Polymorphism** → log() behavior changes by type
- **Abstraction** → developer only calls log()

### Example
```java
abstract class Logger{ abstract void log(String msg); }
class FileLogger extends Logger{ void log(String msg){} }
class CloudLogger extends Logger{ void log(String msg){} }
```

---

## 6) Shopping Cart Price System
### Where used?
- **Inheritance** → base Product class
- **Polymorphism** → discount logic change by item

### Example
```java
class Product{ double price; Product(double p){price=p;} double discount(){return price;} }
class Electronics extends Product{ Electronics(){super(50000);} double discount(){return price*0.9;} }
```

---

## 7) Restaurant Food Calories
### Where used?
- **Abstraction** → calories hidden logic
- **Polymorphism** → different calories per item

```java
abstract class Food{ abstract int calories(); }
class Pizza extends Food{ int calories(){return700;} }
class Burger extends Food{ int calories(){return450;} }
```

---

## 8) Uber/Ola Cab Fare Calculation
### Where used?
- **Inheritance** → Base Cab structure
- **Polymorphism** → fare calculation differs by type

```java
abstract class Cab{ abstract int fare(int km); }
class MiniCab extends Cab{ int fare(int km){ return km*10;} }
class PrimeCab extends Cab{ int fare(int km){ return km*15;} }
```

