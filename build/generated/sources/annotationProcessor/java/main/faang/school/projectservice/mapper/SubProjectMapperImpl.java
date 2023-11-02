package faang.school.projectservice.mapper;

import faang.school.projectservice.dto.subproject.SubProjectDto;
import faang.school.projectservice.model.Project;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T16:23:21+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class SubProjectMapperImpl implements SubProjectMapper {

    @Override
    public SubProjectDto toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        SubProjectDto.SubProjectDtoBuilder subProjectDto = SubProjectDto.builder();

        subProjectDto.parentId( projectParentProjectId( project ) );
        subProjectDto.childrenId( toChildrenId( project.getChildren() ) );
        subProjectDto.id( project.getId() );
        subProjectDto.name( project.getName() );
        subProjectDto.description( project.getDescription() );
        subProjectDto.status( project.getStatus() );
        subProjectDto.visibility( project.getVisibility() );

        return subProjectDto.build();
    }

    @Override
    public void updateFromDto(SubProjectDto subProjectDto, Project project) {
        if ( subProjectDto == null ) {
            return;
        }

        project.setId( subProjectDto.getId() );
        project.setName( subProjectDto.getName() );
        project.setDescription( subProjectDto.getDescription() );
        project.setStatus( subProjectDto.getStatus() );
        project.setVisibility( subProjectDto.getVisibility() );
    }

    @Override
    public Project toEntity(SubProjectDto subProjectDto) {
        if ( subProjectDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( subProjectDto.getId() );
        project.name( subProjectDto.getName() );
        project.description( subProjectDto.getDescription() );
        project.status( subProjectDto.getStatus() );
        project.visibility( subProjectDto.getVisibility() );

        return project.build();
    }

    private Long projectParentProjectId(Project project) {
        if ( project == null ) {
            return null;
        }
        Project parentProject = project.getParentProject();
        if ( parentProject == null ) {
            return null;
        }
        Long id = parentProject.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
