package parser;

import model.Eveniment;

import java.io.IOException;
import java.util.List;

public interface Parser {

        List<Eveniment> parseLogs(String path) throws IOException;
    }

