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
public class StageMapperImpl implements StageMapper {

    @Override
    public List<Stage> toStageList(List<StageDto> stageDto) {
        if ( stageDto == null ) {
            return null;
        }

        List<Stage> list = new ArrayList<Stage>( stageDto.size() );
        for ( StageDto stageDto1 : stageDto ) {
            list.add( toStage( stageDto1 ) );
        }

        return list;
    }

    @Override
    public List<StageDto> toStageDtoList(List<Stage> stage) {
        if ( stage == null ) {
            return null;
        }

        List<StageDto> list = new ArrayList<StageDto>( stage.size() );
        for ( Stage stage1 : stage ) {
            list.add( toStageDto( stage1 ) );
        }

        return list;
    }

    @Override
    public Stage toStage(StageDto stageDto) {
        if ( stageDto == null ) {
            return null;
        }

        Stage.StageBuilder stage = Stage.builder();

        stage.stageId( stageDto.getStageId() );
        stage.stageName( stageDto.getStageName() );
        stage.project( projectDtoToProject( stageDto.getProject() ) );
        stage.stageRoles( stageRolesDtoListToStageRolesList( stageDto.getStageRoles() ) );
        stage.tasks( taskDtoListToTaskList( stageDto.getTasks() ) );

        return stage.build();
    }

    @Override
    public StageDto toStageDto(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        StageDto.StageDtoBuilder stageDto = StageDto.builder();

        stageDto.stageId( stage.getStageId() );
        stageDto.stageName( stage.getStageName() );
        stageDto.project( projectToProjectDto( stage.getProject() ) );
        stageDto.tasks( taskListToTaskDtoList( stage.getTasks() ) );
        stageDto.stageRoles( stageRolesListToStageRolesDtoList( stage.getStageRoles() ) );

        return stageDto.build();
    }

    protected Project projectDtoToProject(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectDto.getId() );
        project.name( projectDto.getName() );
        project.description( projectDto.getDescription() );
        project.status( projectDto.getStatus() );
        project.visibility( projectDto.getVisibility() );
        project.stages( toStageList( projectDto.getStages() ) );

        return project.build();
    }

    protected StageRoles stageRolesDtoToStageRoles(StageRolesDto stageRolesDto) {
        if ( stageRolesDto == null ) {
            return null;
        }

        StageRoles.StageRolesBuilder stageRoles = StageRoles.builder();

        stageRoles.id( stageRolesDto.getId() );
        stageRoles.teamRole( stageRolesDto.getTeamRole() );
        stageRoles.count( stageRolesDto.getCount() );
        stageRoles.stage( toStage( stageRolesDto.getStage() ) );

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

    protected ProjectDto projectToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto.ProjectDtoBuilder projectDto = ProjectDto.builder();

        projectDto.id( project.getId() );
        projectDto.name( project.getName() );
        projectDto.description( project.getDescription() );
        projectDto.stages( toStageDtoList( project.getStages() ) );
        projectDto.status( project.getStatus() );
        projectDto.visibility( project.getVisibility() );

        return projectDto.build();
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
        stageRolesDto.stage( toStageDto( stageRoles.getStage() ) );

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
}
