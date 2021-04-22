package ru.job4j;

class Shell {
    Entity currentEntity = new Entity("/", null);

    Shell cd(final String path) {
        if (path.equals("..")) {
            currentEntity = currentEntity.getParent();
            return this;
        }
        if (path.contains("/")) {
            return this;
        }
        currentEntity = new Entity(currentEntity.getDirectory().equals("/") ? currentEntity.getDirectory() + path : currentEntity.getDirectory() + "/" + path, currentEntity);
        return this;
    }

    public String path() {
        return currentEntity.getDirectory();
    }
}

public class Directory {

    public static void main(String[] args) {

        final Shell shell = new Shell();
        assert shell.path().equals("/");

        shell.cd("/");
        assert shell.path().equals("/");

        shell.cd("usr/..");
        assert shell.path().equals("/");

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assert shell.path().equals("/usr/local");

        shell.cd("..");
        assert shell.path().equals("/usr");

        shell.cd("//lib///");
        assert shell.path().equals("/lib");
    }
}

class Entity {
    Entity parent;
    private final String directory;

    public Entity(String directory, Entity parent) {
        this.directory = directory;
        this.parent = parent;
    }

    public String getDirectory() {
        return directory;
    }

    public Entity getParent() {
        return this.parent;
    }
}