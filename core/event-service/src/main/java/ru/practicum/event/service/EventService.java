package ru.practicum.event.service;


import ru.practicum.dto.EventFullDto;
import ru.practicum.dto.EventShortDto;
import ru.practicum.event.dto.*;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<EventShortDto> getAllEvents(ReqParam reqParam);

    List<EventFullDto> getAllEvents(AdminEventParams params);

    EventFullDto publicGetEvent(long id);

    EventFullDto create(Long userId, NewEventDto newEventDto);

    List<EventShortDto> findUserEvents(Long userId, Integer from, Integer size);

    EventFullDto findUserEventById(Long userId, Long eventId);

    EventFullDto updateEventByUser(Long userId, Long eventId, UpdateEventUserRequest updateEventUserRequest);

    EventFullDto update(Long eventId, UpdateEventAdminRequest updateEventAdminRequest);

    List<EventFullDto> findAllByCategoryId(Long categoryId, Integer from, Integer size);

    Optional<EventFullDto> findOptEventByUserIdAndId(Long userId, Long eventId);

    EventFullDto findEventById(Long eventId);
}