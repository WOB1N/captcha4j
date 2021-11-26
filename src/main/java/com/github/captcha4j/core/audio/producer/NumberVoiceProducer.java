package com.github.captcha4j.core.audio.producer;

import com.github.captcha4j.core.audio.Sample;
import com.github.captcha4j.core.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;

/**
 * <p>
 * {@link VoiceProducer} which generates a vocalization for a given number,
 * randomly selecting from a list of voices available for a given language.
 *
 * @author <a href="mailto:wagenaar.robin@gmail.com">Robin Wagenaar</a>
 * @author <a href="mailto:james.childers@gmail.com">James Childers</a>
 * @author <a href="mailto:subhajitdas298@gmail.com">Subhajit Das</a>
 */
public class NumberVoiceProducer implements VoiceProducer {
    private Language currentLanguage;
    private static final Random RAND = new SecureRandom();

    private static Map<Language, List<String>> VOICES_BY_LANGUAGE = new HashMap<Language, List<String>>(){{
        put(Language.EN, Arrays.asList(
                "alex",
                "bruce",
                "fred",
                "kathy",
                "ralph",
                "vicki",
                "victoria"
        ));

        put(Language.NL, Arrays.asList(
                "robin",
                "vincent",
                "nynke",
                "liesbeth"
        ));
    }};

    public NumberVoiceProducer(Language language){
        this.currentLanguage = language;
    }

    /**
     * Gets the vocalization
     *
     * @param num the number to vocalize
     * @oaram lang the language needed
     * @return the vocal/audio sample of the number
     */
    @Override
    public final Sample getVocalization(char num) {
        try {
            List<String> voices = VOICES_BY_LANGUAGE.get(currentLanguage);
            String randomVoice = voices.get(RAND.nextInt(voices.size()));
            int number = Integer.valueOf(num + "");
            String file = "/sounds/voices/"+currentLanguage.toString().toLowerCase()+"/"+randomVoice+"/"+number+"-"+randomVoice + ".wav";
            System.out.println(file);
            return FileUtil.readSample(file);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expected <num> to be a number, got '" + num + "' instead.", e);
        }
    }

}
