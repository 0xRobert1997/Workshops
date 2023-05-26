package pl.zajavka.domain;

import lombok.*;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producer{
        private Long id;
        private String producerName;
        private String address;
}

