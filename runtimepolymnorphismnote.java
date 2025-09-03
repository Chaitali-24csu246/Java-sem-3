/*
 * class a has methods read
 * classb inherits a and has read overriden and write
 * A a=new B();
 * a.read() -> calls B's read
 * a.write() -> error, a doesn't have write method
 * B b=new B();
 * b.read() -> calls B's read
 * b.write() -> calls B's write
 */
