package faang.school.projectservice.mapper;

import faang.school.projectservice.dto.project.ProjectDto;
import faang.school.projectservice.dto.stage.StageDto;
import faang.school.projectservice.dto.stage.StageRolesDto;
import faang.school.projectservice.dto.task.TaskDto;
import faang.school.projectservice.model.Project;
import faang.school.projectservice.model.Task;
import faang.school.projectservice.model.TaskStatus;
import faang.school.projectservice.model.stage.Stage;
import faang.school.projectservice.model.stage.StageRoles;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-14T15:43:39+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto.ProjectDtoBuilder projectDto = ProjectDto.builder();

        projectDto.parentId( projectParentProjectId( project ) );
        projectDto.childrenId( toChildrenId( project.getChildren() ) );
        projectDto.id( project.getId() );
        projectDto.name( project.getName() );
        projectDto.description( project.getDescription() );
        projectDto.stages( stageListToStageDtoList( project.getStages() ) );
        projectDto.status( project.getStatus() );
        projectDto.visibility( project.getVisibility() );

        return projectDto.build();
    }

    @Override
    public List<ProjectDto> toDtoList(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projects.size() );
        for ( Project project : projects ) {
            list.add( toDto( project ) );
        }

        return list;
    }

    @Override
    public void updateFromDto(ProjectDto projectDto, Project project) {
        if ( projectDto == null ) {
            return;
        }

        project.setId( projectDto.getId() );
        project.setName( projectDto.getName() );
        project.setDescription( projectDto.getDescription() );
        project.setStatus( projectDto.getStatus() );
        project.setVisibility( projectDto.getVisibility() );
        if ( project.getStages() != null ) {
            List<Stage> list = stageDtoListToStageList( projectDto.getStages() );
            if ( list != null ) {
                project.getStages().clear();
                project.getStages().addAll( list );
            }
            else {
                project.setStages( null );
            }
        }
        else {
            List<Stage> list = stageDtoListToStageList( projectDto.getStages() );
            if ( list != null ) {
                project.setStages( list );
            }
        }
    }

    @Override
    public Project toEntity(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectDto.getId() );
        project.name( projectDto.getName() );
        project.description( projectDto.getDescription() );
        project.status( projectDto.getStatus() );
        project.visibility( projectDto.getVisibility() );
        project.stages( stageDtoListToStageList( projectDto.getStages() ) );

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

    protected TaskDto taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskStatus taskStatus = null;

        TaskDto taskDto = new TaskDto( taskStatus );

        return taskDto;
    }

    protected List<TaskDto> taskListToTaskDtoList(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDto> list1 = new ArrayList<TaskDto>( list.size() );
        for ( Task task : list ) {
            list1.add( taskToTaskDto( task ) );
        }

        return list1;
    }

    protected StageRolesDto stageRolesToStageRolesDto(StageRoles stageRoles) {
        if ( stageRoles == null ) {
            return null;
        }

        StageRolesDto.StageRolesDtoBuilder stageRolesDto = StageRolesDto.builder();

        stageRolesDto.id( stageRoles.getId() );
        stageRolesDto.teamRole( stageRoles.getTeamRole() );
        stageRolesDto.count( stageRoles.getCount() );
        stageRolesDto.stage( stageToStageDto( stageRoles.getStage() ) );

        return stageRolesDto.build();
    }

    protected List<StageRolesDto> stageRolesListToStageRolesDtoList(List<StageRoles> list) {
        if ( list == null ) {
            return null;
        }

        List<StageRolesDto> list1 = new ArrayList<StageRolesDto>( list.size() );
        for ( StageRoles stageRoles : list ) {
            list1.add( stageRolesToStageRolesDto( stageRoles ) );
        }

        return list1;
    }

    protected StageDto stageToStageDto(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        StageDto.StageDtoBuilder stageDto = StageDto.builder();

        stageDto.stageId( stage.getStageId() );
        stageDto.stageName( stage.getStageName() );
        stageDto.project( toDto( stage.getProject() ) );
        stageDto.tasks( taskListToTaskDtoList( stage.getTasks() ) );
        stageDto.stageRoles( stageRolesListToStageRolesDtoList( stage.getStageRoles() ) );

        return stageDto.build();
    }

    protected List<StageDto> stageListToStageDtoList(List<Stage> list) {
        if ( list == null ) {
            return null;
        }

        List<StageDto> list1 = new ArrayList<StageDto>( list.size() );
        for ( Stage stage : list ) {
            list1.add( stageToStageDto( stage ) );
        }

        return list1;
    }

    protected StageRoles stageRolesDtoToStageRoles(StageRolesDto stageRolesDto) {
        if ( stageRolesDto == null ) {
            return null;
        }

        StageRoles.StageRolesBuilder stageRoles = StageRoles.builder();

        stageRoles.id( stageRolesDto.getId() );
        stageRoles.teamRole( stageRolesDto.getTeamRole() );
        stageRoles.count( stageRolesDto.getCount() );
        stageRoles.stage( stageDtoToStage( stageRolesDto.getStage() ) );

        return stageRoles.build();
    }

    protected List<StageRoles> stageRolesDtoListToStageRolesList(List<StageRolesDto> list) {
        if ( list == null ) {
            return null;
        }

        List<StageRoles> list1 = new ArrayList<StageRoles>( list.size() );
        for ( StageRolesDto stageRolesDto : list ) {
            list1.add( stageRolesDtoToStageRoles( stageRolesDto ) );
        }

        return list1;
    }

    protected Task taskDtoToTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        return task.build();
    }

    protected List<Task> taskDtoListToTaskList(List<TaskDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Task> list1 = new ArrayList<Task>( list.size() );
        for ( TaskDto taskDto : list ) {
            list1.add( taskDtoToTask( taskDto ) );
        }

        return list1;
    }

    protected Stage stageDtoToStage(StageDto stageDto) {
        if ( stageDto == null ) {
            return null;
        }

        Stage.StageBuilder stage = Stage.builder();

        stage.stageId( stageDto.getStageId() );
        stage.stageName( stageDto.getStageName() );
        stage.project( toEntity( stageDto.getProject() ) );
        stage.stageRoles( stageRolesDtoListToStageRolesList( stageDto.getStageRoles() ) );
        stage.tasks( taskDtoListToTaskList( stageDto.getTasks() ) );

        return stage.build();
    }

    protected List<Stage> stageDtoListToStageList(List<StageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Stage> list1 = new ArrayList<Stage>( list.size() );
        for ( StageDto stageDto : list ) {
            list1.add( stageDtoToStage( stageDto ) );
        }

        return list1;
    }
}
