package com.sunasterisk.book_movie_tickets.data.remote

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sunasterisk.book_movie_tickets.data.local.Genres
import java.lang.reflect.Type


class GenresResponse {
    companion object{
        private val strGenres = "[\n" +
                "    {\n" +
                "      \"id\": 28,\n" +
                "      \"name\": \"Action\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 12,\n" +
                "      \"name\": \"Adventure\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 16,\n" +
                "      \"name\": \"Animation\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 35,\n" +
                "      \"name\": \"Comedy\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 80,\n" +
                "      \"name\": \"Crime\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 99,\n" +
                "      \"name\": \"Documentary\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 18,\n" +
                "      \"name\": \"Drama\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10751,\n" +
                "      \"name\": \"Family\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 14,\n" +
                "      \"name\": \"Fantasy\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 36,\n" +
                "      \"name\": \"History\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 27,\n" +
                "      \"name\": \"Horror\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10402,\n" +
                "      \"name\": \"Music\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 9648,\n" +
                "      \"name\": \"Mystery\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10749,\n" +
                "      \"name\": \"Romance\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 878,\n" +
                "      \"name\": \"Science Fiction\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10770,\n" +
                "      \"name\": \"TV Movie\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 53,\n" +
                "      \"name\": \"Thriller\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10752,\n" +
                "      \"name\": \"War\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 37,\n" +
                "      \"name\": \"Western\"\n" +
                "    }\n" +
                "  ]";
        fun getGenres(): List<Genres> {
            var gson = Gson()
            val collectionType: Type = object : TypeToken<List<Genres?>?>() {}.type
            return gson.fromJson(strGenres, collectionType)
        }
        fun searchGenrs(id : Int):Genres?{
            var rs = mutableListOf<Genres>();
            rs.addAll(getGenres());
            rs.forEach {
                if (it.id == id) return it
            }
            return null;
        }
    }
}
