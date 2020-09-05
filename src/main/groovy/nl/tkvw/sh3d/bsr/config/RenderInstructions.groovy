package nl.tkvw.sh3d.bsr.config

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor


class RenderInstructions {
    String floorplan;
    String camera;
    String output;
    String format;
    Integer width;
    Integer height;
    String timezone;
    String timestamp;
    String timestampFormat;
    List<Scenario> scenarios;

    static RenderInstructions fromYamlConfig(String config){
        Yaml yaml = new Yaml(new Constructor(RenderInstructions.class));
        return yaml.load(new FileInputStream(config));
    }
}
