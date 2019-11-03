package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloCreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloClient.getTrellloBoards();


/*
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {

            System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());

            System.out.println("This board contains lists: ");

            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

         });
*/
      /*
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(t -> t.getName().contains("Kodilla"))
                .forEach(t -> System.out.println(t.getId() + " " + t.getName()));

      //  trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
*/
    }
    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public TrelloCreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }

}