```sql
+----------------------+
|     Decodificador    |
+----------------------+
| - grilla             |
| - reproducidas       |
| - criterio           |
+----------------------+
| + sugerir()          |
| + setCriterio()      |
| + reproducir()       |
+----------------------+
           |
           v
+---------------------------+
|   CriterioSugerencia      |
+---------------------------+
| + sugerir(decodificador)  |
+---------------------------+
      ^         ^         ^
      |         |         |
      |         |         |
+-----------+ +--------------+ +------------+
| Novedad   | | Similaridad  | | Puntaje   |
+-----------+ +--------------+ +------------+


+----------------------+
|      Pelicula        |
+----------------------+
| - titulo             |
| - anioEstreno        |
| - puntaje            |
| - similares          |
+----------------------+
| + agregarSimilar()   |
+----------------------+

```