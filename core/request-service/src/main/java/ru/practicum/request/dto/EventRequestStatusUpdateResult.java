package ru.practicum.request.dto;


import lombok.Getter;
import lombok.Setter;
import ru.practicum.dto.ParticipationRequestDto;

import java.util.List;

@Getter
@Setter
public class EventRequestStatusUpdateResult {
    private List<ParticipationRequestDto> confirmedRequests;
    private List<ParticipationRequestDto> rejectedRequests;
}