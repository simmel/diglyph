package se.soy.diglyph;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import org.projectodd.yaml.*;

class Config {
  static final public int VERSION = 1;

  public static void verify(File config) throws FileNotFoundException, SchemaException {
    InputStream schemaFile = Config.class.getResourceAsStream("/diglyph-v" + VERSION + "-schema.yaml");
    Schema schema = new Schema(schemaFile);
    schema.validate(new FileInputStream(config));
  }

  public static DatabaseV1 load(File config) throws FileNotFoundException, SchemaException {
    // https://code.google.com/p/snakeyaml/wiki/Documentation
    Config.verify(config);

    Yaml yaml = new Yaml(new Constructor(DatabaseV1.class));
    DatabaseV1 obj = (DatabaseV1)yaml.load(new FileInputStream(config));
    return obj;
  }
}
