package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            StudyWrapper studyWrapper = objectMapper.readValue(new File("jsonformatter.txt"), StudyWrapper.class);
            StudyWrapper.StudyDefinition studyDefinition = studyWrapper.getStudyDefinition();

            System.out.println("Study ID: " + studyDefinition.getStudyId());
            System.out.println("Study Name: " + studyDefinition.getStudyName());
            // Add more print statements to verify other fields

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
class StudyWrapper {
    @Getter
    @Setter
    @NoArgsConstructor
    @Data
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    class StudyDefinition {
        private Header header;
        private String studyId;
        private String studyName;
        private String studyStatusId;
        private String aspect;
        private List<List<Group>> children;
        }
    @JsonProperty("StudyDefinition")
    private StudyDefinition studyDefinition;

    @JsonIgnoreProperties(ignoreUnknown = true)

    static class Header {
        private String serviceAction;
        private String reqTimeStamp;
        private String username;

        // Getters and setters
    }
    @JsonIgnoreProperties(ignoreUnknown = true)

    static class Group {
        private String groupId;
        private String groupName;
        private String groupType;
        private List<List<Group>> children;
        private List<Attribute> attributeData;

        // Getters and setters


    }
    static class Attribute {
        private String entityId;
        private String entityValueId;
        private String name;
        private String value;

        // Getters and setters
    }
}


