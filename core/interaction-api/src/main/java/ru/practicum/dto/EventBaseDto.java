package ru.practicum.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventBaseDto {
    private String annotation;
    private CategoryDto category;
    private Long confirmedRequests;
    private Long id;
    private UserShortDto initiator;
    private Boolean paid;
    private String title;
    private Double rating;
    private Long commentsCount;
}
