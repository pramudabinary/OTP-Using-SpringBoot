package com.example.otp.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 1/6/22
 **/

public class EmailTemplate {

    private String template;
    private Map replacementParams;

    public EmailTemplate(String customtemplate) {

        try {
            this.template = loadTemplate(customtemplate);
        } catch (Exception e) {
            this.template = "Empty";
        }

    }

    private String loadTemplate(String customtemplate) throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(customtemplate).getFile());
        String content = "Empty";
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new Exception("Could not read template  = " + customtemplate);
        }
        return content;

    }

    public String getTemplate(Map replacements) {

        String cTemplate = this.template;
        //Replace the String
        for (Object entry : replacements.entrySet()) {
            cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", (CharSequence) entry.getValue());
        }
        return cTemplate;
    }
}
}
