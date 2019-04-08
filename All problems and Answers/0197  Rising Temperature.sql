SELECT  w2.Id 
FROM    Weather w1, Weather w2
WHERE   w2.Recorddate = dateadd(day, 1, w1.Recorddate)
AND     w1.Temperature < w2.Temperature
