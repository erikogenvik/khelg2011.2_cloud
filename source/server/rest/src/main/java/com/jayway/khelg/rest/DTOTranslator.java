package com.jayway.khelg.rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.core.UriInfo;

import com.jayway.khelg.domain.Entry;
import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.domain.Topic;
import com.jayway.khelg.rest.dto.EntryDTO;
import com.jayway.khelg.rest.dto.ForumDTO;
import com.jayway.khelg.rest.dto.TopicDTO;

public class DTOTranslator {

    public static Collection<ForumDTO> translateForumsToDTO(UriInfo uriInfo, Collection<Forum> forums) {
        Collection<ForumDTO> dtos = new ArrayList<ForumDTO>();
        for (Forum forum : forums) {
            dtos.add(translateForumToDTO(uriInfo, forum));
        }
        return dtos;
    }

    public static Collection<TopicDTO> translateTopicsToDTO(UriInfo uriInfo, Collection<? extends Topic> topics) {
        Collection<TopicDTO> dtos = new ArrayList<TopicDTO>();
        for (Topic topic : topics) {
            dtos.add(translateTopicToDTO(uriInfo, topic));
        }
        return dtos;
    }

    public static Collection<EntryDTO> translateEntriesToDTO(UriInfo uriInfo, Collection<? extends Entry> entries) {
        Collection<EntryDTO> dtos = new ArrayList<EntryDTO>();
        for (Entry entry : entries) {
            dtos.add(translateEntryToDTO(uriInfo, entry));
        }
        return dtos;
    }

    public static EntryDTO translateEntryToDTO(UriInfo uriInfo, Entry entry) {
        EntryDTO dto = new EntryDTO();
        dto.id = entry.getId();
        dto.header = entry.getHeader();
        dto.message = entry.getMessage();
        dto.date = entry.getDate();
        dto.addLink(uriInfo.getBaseUri().resolve("/entry/" + Long.toString(entry.getId())), "uri:khelg:entry");
        return dto;
    }

    public static TopicDTO translateTopicToDTO(UriInfo uriInfo, Topic topic) {
        TopicDTO dto = new TopicDTO();
        dto.id = topic.getId();
        dto.header = topic.getHeader();
        dto.addLink(uriInfo.getBaseUri().resolve("/topic/" + Long.toString(topic.getId())), "uri:khelg:topic");
        dto.addLink(uriInfo.getBaseUri().resolve("/topic/" + Long.toString(topic.getId()) + "/entries"), "uri:khelg:topic:entries");
        return dto;
    }

    public static ForumDTO translateForumToDTO(UriInfo uriInfo, Forum forum) {
        ForumDTO dto = new ForumDTO();
        dto.id = forum.getId();
        dto.name = forum.getName();
        dto.addLink(uriInfo.getBaseUri().resolve(Long.toString(forum.getId())), "uri:khelg:forum");
        dto.addLink(uriInfo.getBaseUri().resolve(Long.toString(forum.getId()) + "/topics"), "uri:khelg:forum:topics");

        return dto;
    }

}
