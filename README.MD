# Batch Scenario Renderer

BSR for Sweet Home 3d allows batch rendering of multiple scenarios from a `Yaml` configuration file. 
Basically you define your scenarios in a config: 

```yaml
floorplan: myfloorplan.sh3d
output: images
width: 1024 # Default width of all images (will honor expected ratio of camera setting)
timezone: Europe/Amsterdam # Where is the camera?
timestampFormat: dd-MM-yyyy HH:mm:ss
# The default timestamp to render images from
timestamp: 02-09-2020 19:45:00
format: png
scenarios:
  - name: daytime
    timestamp: 02-09-2020 12:00:00
    pictures:
      - name: base
  - name: dawn
    pictures:
      - name: base
      - name: alarm
        lights:
          - name: rgb01_r # override the power of an image
            power: 70
          - name: rgb02_r
            power: 70
```

## Installation

Clone this repository: 
```
git clone https://github.com/tkvw/groovy.sh3d.bsr
```

## Requirements

You'll need: 
* A Java JDK
* Imagemagick (should be on the path, `scoop fixes this automatically`)
 
### Java JDK 

On windows you can easily install a JDK using [scoop](https://scoop.sh)
```
scoop add bucket java
scoop install oraclejdk
```

### Imagemagick

On windows you can easily install a ImageMagick using [scoop](https://scoop.sh)
```
scoop install imagemagick
```

## Run

### Setup (once)

First startup will take some time (gradle will download all dependencies)

```bash
gradlew prepare   # This will download sweethome from sourceforge
```

### Run

```
gradlew runApp -Pconfig=<configuration_file.yaml>
```

### Overlays 

After Sweethome 3d has finished rendering the images, there is a task to generate the overlays: 
```
gradlew generateOverlays -Pconfig=<configuration_file.yaml>
```