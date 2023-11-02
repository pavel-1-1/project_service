package faang.school.projectservice.mapper.invitationMaper;

import faang.school.projectservice.dto.invitation.DtoStage;
import faang.school.projectservice.dto.invitation.StageInvitationDto;
import faang.school.projectservice.dto.redis.InviteSentEventDto;
import faang.school.projectservice.model.Project;
import faang.school.projectservice.model.TeamMember;
import faang.school.projectservice.model.stage.Stage;
import faang.school.projectservice.model.stage_invitation.StageInvitation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T16:23:21+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class StageInvitationMapperImpl implements StageInvitationMapper {

    @Override
    public StageInvitation toStageInvitation(StageInvitationDto dto) {
        if ( dto == null ) {
            return null;
        }

        StageInvitation.StageInvitationBuilder stageInvitation = StageInvitation.builder();

        stageInvitation.author( stageInvitationDtoToTeamMember( dto ) );
        stageInvitation.invited( stageInvitationDtoToTeamMember1( dto ) );
        stageInvitation.stage( dtoStageToStage( dto.getStage() ) );
        stageInvitation.description( dto.getDescription() );
        stageInvitation.status( dto.getStatus() );

        return stageInvitation.build();
    }

    @Override
    public StageInvitationDto toDto(StageInvitation stageInvitation) {
        if ( stageInvitation == null ) {
            return null;
        }

        String description = null;
        DtoStage stage = null;

        description = stageInvitation.getDescription();
        stage = stageToDtoStage( stageInvitation.getStage() );

        long userIdAuthor = 0L;
        long userIdInvited = 0L;

        StageInvitationDto stageInvitationDto = new StageInvitationDto( description, userIdAuthor, userIdInvited, stage );

        stageInvitationDto.setIdAuthor( stageInvitationAuthorId( stageInvitation ) );
        stageInvitationDto.setIdInvited( stageInvitationInvitedId( stageInvitation ) );
        stageInvitationDto.setStatus( stageInvitation.getStatus() );

        return stageInvitationDto;
    }

    @Override
    public InviteSentEventDto toEventDto(StageInvitation stageInvitation) {
        if ( stageInvitation == null ) {
            return null;
        }

        InviteSentEventDto.InviteSentEventDtoBuilder inviteSentEventDto = InviteSentEventDto.builder();

        Long id = stageInvitationAuthorId( stageInvitation );
        if ( id != null ) {
            inviteSentEventDto.authorId( id );
        }
        Long id1 = stageInvitationInvitedId( stageInvitation );
        if ( id1 != null ) {
            inviteSentEventDto.invitedId( id1 );
        }
        Long id2 = stageInvitationStageProjectId( stageInvitation );
        if ( id2 != null ) {
            inviteSentEventDto.projectId( id2 );
        }

        return inviteSentEventDto.build();
    }

    protected TeamMember stageInvitationDtoToTeamMember(StageInvitationDto stageInvitationDto) {
        if ( stageInvitationDto == null ) {
            return null;
        }

        TeamMember.TeamMemberBuilder teamMember = TeamMember.builder();

        teamMember.id( stageInvitationDto.getIdAuthor() );

        return teamMember.build();
    }

    protected TeamMember stageInvitationDtoToTeamMember1(StageInvitationDto stageInvitationDto) {
        if ( stageInvitationDto == null ) {
            return null;
        }

        TeamMember.TeamMemberBuilder teamMember = TeamMember.builder();

        teamMember.id( stageInvitationDto.getIdInvited() );

        return teamMember.build();
    }

    protected Stage dtoStageToStage(DtoStage dtoStage) {
        if ( dtoStage == null ) {
            return null;
        }

        Stage.StageBuilder stage = Stage.builder();

        stage.stageId( dtoStage.getStageId() );

        return stage.build();
    }

    private Long stageInvitationAuthorId(StageInvitation stageInvitation) {
        if ( stageInvitation == null ) {
            return null;
        }
        TeamMember author = stageInvitation.getAuthor();
        if ( author == null ) {
            return null;
        }
        Long id = author.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long stageInvitationInvitedId(StageInvitation stageInvitation) {
        if ( stageInvitation == null ) {
            return null;
        }
        TeamMember invited = stageInvitation.getInvited();
        if ( invited == null ) {
            return null;
        }
        Long id = invited.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected DtoStage stageToDtoStage(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        DtoStage dtoStage = new DtoStage();

        dtoStage.setStageId( stage.getStageId() );

        return dtoStage;
    }

    private Long stageInvitationStageProjectId(StageInvitation stageInvitation) {
        if ( stageInvitation == null ) {
            return null;
        }
        Stage stage = stageInvitation.getStage();
        if ( stage == null ) {
            return null;
        }
        Project project = stage.getProject();
        if ( project == null ) {
            return null;
        }
        Long id = project.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
