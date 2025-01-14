# Captcha4J

### Captcha4j-core
Tiny java library for generating images and audio-fragments for use in Captcha's. 

Features:
- Fluent java api for easy customization of the captcha and difficulty level.
- Supports internationalization for audio, with multiple English and Dutch voices included (easily extensible)
- Minimal number of third party libraries required. 

### Captcha4j-web-demo
Spring-boot based reference implementation for using Captcha4j-core in a real-world(ish) environment.  

Features:
- Completely stateless back-end (easy to use horizontally scaled applications) for generating, refreshing and validating captcha's. 
- Simple-to-read HTML/JS front-end that consumes these webservices.

## Usage

### Build captcha
```java
ImageCaptcha imageCaptcha = new ImageCaptchaBuilder(200, 50)
        .addAnswer("123abc")
        .addNoise()
        .addBackground()
        .build();
BufferedImage image = imageCaptcha.getImage()

AudioCaptcha audioCaptcha = new AudioCaptchaBuilder()
        .addRandomAnswer()
        .addVoice(Language.NL)
        .addNoise()
        .build();
AudioInputStream stream = audioCaptcha.getAudio().getAudioInputStream();
```

### Example output:
![captcha-example-1](https://github.com/RobinWagenaar/captcha4j/raw/main/captcha4j-examples/captcha-1.png)
![captcha-example-2](https://github.com/RobinWagenaar/captcha4j/raw/main/captcha4j-examples/captcha-2.png)
![captcha-example-4](https://github.com/RobinWagenaar/captcha4j/raw/main/captcha4j-examples/captcha-4.png)
![captcha-example-3](https://github.com/RobinWagenaar/captcha4j/raw/main/captcha4j-examples/captcha-3.png)


## Credits
This project is forked from Stateless-captcha 1.2.1 (https://github.com/sdtool/stateless-captcha), which was in turn based on SimpleCaptcha 
version 1.2.1 (http://simplecaptcha.sourceforge.net/). There are significant backwards-incompatible changes breaking compatibility with the
original works (mix-and-match is not recommended :)). 
