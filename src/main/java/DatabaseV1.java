package se.soy.diglyph;
import java.util.Map;
import java.util.List;

public class DatabaseV1 {
  static final public int VERSION = 1;
  public Map<String,String> diglyph;
  public Map<String,List> acl;
  public Map<String,Passwords> passwords;
}
