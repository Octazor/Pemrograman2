package soal1;

abstract class Shape {
 private String name;

 public Shape(String name) {
     this.name = name;
 }

 public abstract double area();

 @Override
 public String toString() {
     return name;
 }
}
