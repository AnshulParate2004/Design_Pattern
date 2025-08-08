package Prototype_Design_Patterns.Students;
interface Prototype {
    Prototype clone();
}

class StudentRecord implements Prototype{
    private int id;
    private String name;
    private String collage;

    public StudentRecord(int id,String name,String collage){
        this.id = id;
        this.name = name;
        this.collage = collage;
    }

    @Override
    public Prototype clone(){
        return new StudentRecord(id,name,collage);

    }
    public void showRecord(){
        System.out.println("ID:" + id + ",Name" + name);
    }

}
