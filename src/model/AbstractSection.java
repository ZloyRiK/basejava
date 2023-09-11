package model;

public abstract class AbstractSection<S extends Section> {

    public S section;

    public abstract void Create();
    public abstract void Update();
    public abstract void Delete();
}
