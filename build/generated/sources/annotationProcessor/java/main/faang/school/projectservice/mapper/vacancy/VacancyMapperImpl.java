package faang.school.projectservice.mapper.vacancy;

import faang.school.projectservice.dto.Vacancy.CreateVacancyDto;
import faang.school.projectservice.dto.Vacancy.ExtendedVacancyDto;
import faang.school.projectservice.dto.Vacancy.UpdateVacancyDto;
import faang.school.projectservice.model.Candidate;
import faang.school.projectservice.model.Project;
import faang.school.projectservice.model.Vacancy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T16:23:21+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class VacancyMapperImpl implements VacancyMapper {

    @Override
    public ExtendedVacancyDto toDto(Vacancy vacancy) {
        if ( vacancy == null ) {
            return null;
        }

        ExtendedVacancyDto.ExtendedVacancyDtoBuilder extendedVacancyDto = ExtendedVacancyDto.builder();

        extendedVacancyDto.projectId( vacancyProjectId( vacancy ) );
        extendedVacancyDto.candidateIds( toCandidateIds( vacancy.getCandidates() ) );
        extendedVacancyDto.id( vacancy.getId() );
        extendedVacancyDto.name( vacancy.getName() );
        extendedVacancyDto.description( vacancy.getDescription() );
        extendedVacancyDto.createdAt( vacancy.getCreatedAt() );
        extendedVacancyDto.updatedAt( vacancy.getUpdatedAt() );
        extendedVacancyDto.createdBy( vacancy.getCreatedBy() );
        extendedVacancyDto.updatedBy( vacancy.getUpdatedBy() );
        extendedVacancyDto.status( vacancy.getStatus() );
        extendedVacancyDto.salary( vacancy.getSalary() );
        extendedVacancyDto.workSchedule( vacancy.getWorkSchedule() );
        extendedVacancyDto.count( vacancy.getCount() );
        List<Long> list1 = vacancy.getRequiredSkillIds();
        if ( list1 != null ) {
            extendedVacancyDto.requiredSkillIds( new ArrayList<Long>( list1 ) );
        }

        return extendedVacancyDto.build();
    }

    @Override
    public Vacancy toEntity(CreateVacancyDto vacancyDto) {
        if ( vacancyDto == null ) {
            return null;
        }

        Vacancy.VacancyBuilder vacancy = Vacancy.builder();

        vacancy.id( vacancyDto.getId() );
        vacancy.name( vacancyDto.getName() );
        vacancy.description( vacancyDto.getDescription() );
        vacancy.salary( vacancyDto.getSalary() );
        vacancy.workSchedule( vacancyDto.getWorkSchedule() );
        vacancy.count( vacancyDto.getCount() );
        List<Long> list = vacancyDto.getRequiredSkillIds();
        if ( list != null ) {
            vacancy.requiredSkillIds( new ArrayList<Long>( list ) );
        }

        return vacancy.build();
    }

    @Override
    public void updateFromDto(UpdateVacancyDto vacancyDto, Vacancy vacancy) {
        if ( vacancyDto == null ) {
            return;
        }

        if ( vacancy.getCandidates() != null ) {
            List<Candidate> list = toCandidateEntities( vacancyDto.getCandidateIds() );
            if ( list != null ) {
                vacancy.getCandidates().clear();
                vacancy.getCandidates().addAll( list );
            }
            else {
                vacancy.setCandidates( null );
            }
        }
        else {
            List<Candidate> list = toCandidateEntities( vacancyDto.getCandidateIds() );
            if ( list != null ) {
                vacancy.setCandidates( list );
            }
        }
        vacancy.setId( vacancyDto.getId() );
        vacancy.setName( vacancyDto.getName() );
        vacancy.setDescription( vacancyDto.getDescription() );
        vacancy.setStatus( vacancyDto.getStatus() );
        vacancy.setSalary( vacancyDto.getSalary() );
        vacancy.setWorkSchedule( vacancyDto.getWorkSchedule() );
        vacancy.setCount( vacancyDto.getCount() );
        if ( vacancy.getRequiredSkillIds() != null ) {
            List<Long> list1 = vacancyDto.getRequiredSkillIds();
            if ( list1 != null ) {
                vacancy.getRequiredSkillIds().clear();
                vacancy.getRequiredSkillIds().addAll( list1 );
            }
            else {
                vacancy.setRequiredSkillIds( null );
            }
        }
        else {
            List<Long> list1 = vacancyDto.getRequiredSkillIds();
            if ( list1 != null ) {
                vacancy.setRequiredSkillIds( new ArrayList<Long>( list1 ) );
            }
        }
    }

    @Override
    public List<ExtendedVacancyDto> entityListToDtoList(List<Vacancy> vacancies) {
        if ( vacancies == null ) {
            return null;
        }

        List<ExtendedVacancyDto> list = new ArrayList<ExtendedVacancyDto>( vacancies.size() );
        for ( Vacancy vacancy : vacancies ) {
            list.add( toDto( vacancy ) );
        }

        return list;
    }

    private Long vacancyProjectId(Vacancy vacancy) {
        if ( vacancy == null ) {
            return null;
        }
        Project project = vacancy.getProject();
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
