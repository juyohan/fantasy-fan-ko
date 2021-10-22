package com.example.demo

import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
data class Result<T>(
    var data : T
) {
}
