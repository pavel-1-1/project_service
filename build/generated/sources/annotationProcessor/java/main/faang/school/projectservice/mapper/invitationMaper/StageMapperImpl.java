package faang.school.projectservice.mapper.invitationMaper;

import faang.school.projectservice.dto.invitation.DtoStage;
import faang.school.projectservice.model.stage.Stage;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T16:23:21+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class StageMapperImpl implements StageMapper {

    @Override
    public Stage toStage(DtoStage dtoStage) {
        if ( dtoStage == null ) {
            return null;
        }

        Stage.StageBuilder stage = Stage.builder();

        stage.stageId( dtoStage.getStageId() );

        return stage.build();
    }

    @Override
    public DtoStage toDtoStage(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        DtoStage dtoStage = new DtoStage();

        dtoStage.setStageId( stage.getStageId() );

        return dtoStage;
    }
}
