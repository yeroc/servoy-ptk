package org.geekden.servoy.ptk;

public class MethodInfo
{
  private final String name;
  private final String[] parameters;
  private final String sample;
  private final String tooltip;
  private final boolean deprecated;
  
  private MethodInfo(String name, String[] parameters, String sample, String tooltip, boolean deprecated)
  {
    this.name = name;
    this.parameters = parameters;
    this.sample = sample;
    this.tooltip = tooltip;
    this.deprecated = deprecated;
  }
  
  public String name() { return name; }
  public String[] parameters() { return parameters; }
  public String sample() { return sample; }
  public String tooltip() { return tooltip; }
  public boolean deprecated() { return deprecated; }
  
  public static Builder method(String name)
  { return new Builder(name); }
  
  public static final class Builder
  {
    private String name = "";
    private String[] parameters = new String[] {};
    private String sample = "";
    private String tooltip = "";
    private boolean deprecated = false;
    
    public Builder(String name) { name(name); }
    private Builder name(String name) { this.name = name; return this; }
    public Builder parameters(String... parms) { this.parameters = parms; return this; }
    public Builder sample(String sample) { this.sample = sample; return this; }
    public Builder tooltip(String tooltip) { this.tooltip = tooltip; return this; }
    public Builder deprecated(boolean deprecated) { this.deprecated = deprecated; return this; }
    
    public MethodInfo build()
    { return new MethodInfo(name, parameters, sample, tooltip, deprecated); }
  }
}
