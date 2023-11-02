package faang.school.projectservice.mapper.invitationMaper;

import faang.school.projectservice.dto.invitation.DtoTeamMember;
import faang.school.projectservice.model.TeamMember;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T16:23:21+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class TeamMemberMapperImpl implements TeamMemberMapper {

    @Override
    public TeamMember toTeamMember(Long id) {
        if ( id == null ) {
            return null;
        }

        TeamMember.TeamMemberBuilder teamMember = TeamMember.builder();

        teamMember.id( id );

        return teamMember.build();
    }

    @Override
    public DtoTeamMember toDtoTeamMember(TeamMember teamMember) {
        if ( teamMember == null ) {
            return null;
        }

        Long id = null;

        id = teamMember.getId();

        DtoTeamMember dtoTeamMember = new DtoTeamMember( id );

        return dtoTeamMember;
    }
}
