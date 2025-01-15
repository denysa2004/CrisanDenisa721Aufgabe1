package parser;

import model.Eveniment;
import model.Haus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLParser {




        private static final Pattern POINTS_PATTERN = Pattern.compile("\\p{javaSpaceChar}*<Datum>(-?\\d+)</Datum>");
        private static final Pattern AUTHOR_PATTERN = Pattern.compile("\\p{javaSpaceChar}*<Ereignis>(.*)</Ereignis>");
        private static final Pattern HOUSE_PATTERN = Pattern.compile("\\p{javaSpaceChar}*<Haus>(.*)</Haus>");
    private static final Pattern ID_PATTERN = Pattern.compile("\\p{javaSpaceChar}*<Id>(\\d+)</Id>");
    private static final Pattern NAME_PATTERN = Pattern.compile("\\p{javaSpaceChar}*<Mitgliedsname>(.*)</Mitgliedsname>");

        private static parser.XMLParser instance;

        private XMLParser() {
        }

        public static parser.XMLParser getInstance() {
            if (instance == null) {
                instance = new parser.XMLParser();
            }
            return instance;
        }

        /**
         * Parse the XML file and return a list of students
         *
         * @param path the path of the XML file to be parsed
         * @return List of students
         * @throws IOException if an I/O error occurs
         */
        public List<Eveniment> parseStudents(String path) throws IOException {
            Path filePath = Path.of(path);

            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                if (!reader.readLine().equals("<logs>")) {
                    throw new IOException("Invalid file");
                }

                List<Eveniment> students = new ArrayList<>();
                String nextLine = reader.readLine();

                while (!nextLine.equals("</logs>")) {
                    students.add(parseResult(reader, nextLine));
                    nextLine = reader.readLine();
                }
                return students;
            }
        }

        /**
         * Parses a single student entry
         *
         * @param reader the Reader to read from
         * @param firstLine the first line that was already read
         * @return the parsed Student
         */
        private Eveniment parseResult(BufferedReader reader, String firstLine) throws IOException {
            Eveniment eveniment= new Eveniment();

            if (!firstLine.contains("<log>")) {
                throw new IOException("Invalid  file");
            }

            String nextLine = reader.readLine();
            while (true) {
                parseField(reader, nextLine,eveniment);
                nextLine = reader.readLine();
                if (nextLine.contains("</log>")) {
                    return eveniment;
                }
            }
        }

        /**
         * Parses the next student field
         *
         * @param reader the Reader to read from
         * @param firstLine the first line that was already read
         * @param student the Student where the field is set
         */
        private void parseField(BufferedReader reader, String firstLine, Eveniment student) throws IOException {


            Matcher pointsMatcher = POINTS_PATTERN.matcher(firstLine);
            if (pointsMatcher.matches()) {
                student.setDate(pointsMatcher.group(1));
            }

            Matcher authorMatcher = AUTHOR_PATTERN.matcher(firstLine);
            if (authorMatcher.matches()) {
                student.setEreignis(authorMatcher.group(1));
            }

            Matcher houseMatcher = HOUSE_PATTERN.matcher(firstLine);
            if (houseMatcher.matches()) {
                try {
                    // Convert the house string to the corresponding Haus enum value
                    student.setHaus(Haus.valueOf(houseMatcher.group(1).toUpperCase()));
                } catch (IllegalArgumentException e) {
                    throw new IOException("Invalid Haus value: " + houseMatcher.group(1), e);
                }
            }

            Matcher idMatcher = ID_PATTERN.matcher(firstLine);
            if (idMatcher.matches()) {
                student.setId(Integer.parseInt(idMatcher.group(1)));
            }

            Matcher nameMatcher = NAME_PATTERN.matcher(firstLine);
            if (nameMatcher.matches()) {
                student.setName(nameMatcher.group(1));
            }
        }
    }
