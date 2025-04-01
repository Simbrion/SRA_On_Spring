package com.sra.service.spaceoperations;
import com.sra.config.Config;
import com.sra.model.Space;
import com.sra.repository.SpacesDataRepository;
import com.sra.util.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SpaceNameModifier {

    private final Reader reader;
    private final SpacesDataRepository spacesDataRepository;

    @Autowired
    public SpaceNameModifier (Reader reader, SpacesDataRepository spacesDataRepository) {
        this.reader = reader;
        this.spacesDataRepository = spacesDataRepository;
    }

    public void start(Space space) throws IOException {
        System.out.println(Config.YELLOW_COLOUR + "Please provide a new name for the space " + space.getName() + ". Insert \"N\" if you do not want to change the name." + Config.RESET_COLOUR);
        String userInput = reader.readLine();
        if (!(userInput.equalsIgnoreCase("n"))) {
            space.setName(userInput);
            spacesDataRepository.updateSpaceName(space.getId(), userInput);
        }
    }


}
