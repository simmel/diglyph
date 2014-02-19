package se.soy.diglyph;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileNotFoundException;
import org.projectodd.yaml.SchemaException;

class diglyph {
  public static void main(String args[]) throws FileNotFoundException, SchemaException {
    File config = new File("diglyph.yaml");
    Databasev1 db;
    try {
      db = Config.load(config);
    }
    catch (SchemaException e) {
      System.err.println("Error validating database \"" + config + ": " + e);
      throw e;
    }
    System.out.println("WOOP");
    System.out.println(db.passwords.get("Cisco").entries.get(0).get("note"));
  }
}
