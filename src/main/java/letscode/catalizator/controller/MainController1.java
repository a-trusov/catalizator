package letscode.catalizator.controller;

import letscode.catalizator.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/controller1")
public class MainController1 {
    @GetMapping
    public Flux<Message> list(@RequestParam(defaultValue = "0") Long start,
                              @RequestParam(defaultValue = "3") Long count) {
        return Flux
                .just(
                        "Hello 1",
                        "Hello 2",
                        "Hello 3",
                        "Hello 4",
                        "Hello 5"
                )
                .skip(start)
                .take(count)
                .map(Message::new);
    }
}
