package com.sametb.hoopsinsight.domain.model.player_paging

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.model.player_paging
* Created by SAMET BAYAT 
* on 4.02.2024 at 12:31 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

val  Luka_Dončić =
    """
        {
            "id": 10,
            "awards": [
                {
                    "count": 1,
                    "name": "All-Rookie Team"
                },
                {
                    "count": 4,
                    "name": "All-NBA"
                },
                {
                    "count": 3,
                    "name": "NBA Player of the Month"
                },
                {
                    "count": 9,
                    "name": "NBA Player of the Week"
                },
                {
                    "count": 5,
                    "name": "NBA Rookie of the Month"
                },
                {
                    "count": 1,
                    "name": "NBA Rookie of the Year"
                }
            ],
            "cmsBio": "Luka Dončić (LOO-kuh DON-chitch) has put up historic numbers through first two NBA seasons, producing one of the best starts to a career the league has ever seen. He turned just 21 years old on Feb. 28, 2020, and finished with the second-highest scoring average (24.2 ppg) by a player before his 21st birthday in league history (LeBron James, 25.0 ppg). He also produced 21 of his franchise-record 25 triple-doubles before his 21st birthday, by far the most by a player before turning 21 in league history.Dončić (6-7, 230) was originally selected by Atlanta with the third overall pick in the 2018 NBA Draft, before having his draft rights traded to Dallas in exchange for the draft rights to the fifth overall pick Trae Young and a future first-round selection. He holds career averages of 24.7 points, 8.5 rebounds, 7.3 assists, 1.1 steals and 32.8 minutes per game in 133 games (all starts) with the Mavericks.After an outstanding first season that saw him earn Kia Rookie of the Year honors in 2018-19, Dončić garnered All-NBA First Team accolades as a 21-year-old in 2019-20. He became the first player to earn All-NBA First Team honors in either his first or second season since Tim Duncan in 1998-99. He also became the sixth player in league history to be named All-NBA First Team at age 21-or-younger (James, Max Zaslofsky, Kevin Durant, Duncan, Rick Barry). Dončić joined the great Dirk Nowitzki (2004-05, 2005-06, 2006-07, 2008-09) as the only Mavericks to be tabbed All-NBA First Team.The Slovenian (20 years, 353 days) became the youngest European-born player to start an All-Star Game when suited up for Team LeBron at All-Star 2020 in Chicago. He also took home Western Conference Player of the Month (November 2019) and Player of the Week (Nov. 18 through Nov. 24, 2019) honors in 2019-20.Dončić finished fourth in voting for the Kia Most Valuable Player Award and third in voting for the Kia NBA Most Improved Player Award in 2019-20. At 21 years, 168 days old on the final day of the 2019-20 regular season, he became the youngest player in NBA history to lead the league outright in triple-doubles (17).BEFORE NBABefore being taken with the third pick in the draft, Dončić led Spain’s Real Madrid to the 2018 EuroLeague title while becoming the youngest player ever to earn EuroLeague and EuroLeague Final Four MVP honors. He has also competed for the Slovenian national team and helped the squad to a gold-medal finish at EuroBasket 2017.PERSONAL LIFEA native of Ljubljana, Slovenia, Dončić began his basketball career as a youth player for Olimpija at age 8. He signed a five-year contract with Real Madrid at age 13.",
            "info": {
                "BIRTHDATE": "1999-02-28T00:00:00",
                "COUNTRY": "Slovenia",
                "DISPLAY_FIRST_LAST": "Luka Doncic",
                "DISPLAY_FI_LAST": "L. Doncic",
                "DISPLAY_LAST_COMMA_FIRST": "Doncic, Luka",
                "DLEAGUE_FLAG": "N",
                "DRAFT_NUMBER": "3",
                "DRAFT_ROUND": "1",
                "DRAFT_YEAR": "2018",
                "FIRST_NAME": "Luka",
                "FROM_YEAR": 2018,
                "GAMES_PLAYED_CURRENT_SEASON_FLAG": "Y",
                "GAMES_PLAYED_FLAG": "Y",
                "GREATEST_75_FLAG": "N",
                "HEIGHT": "6-7",
                "IMAGE": "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1629029.png",
                "JERSEY": "77",
                "LAST_AFFILIATION": "Real Madrid/Slovenia",
                "LAST_NAME": "Doncic",
                "NBA_FLAG": "Y",
                "PERSON_ID": 1629029,
                "PLAYERCODE": "luka_don",
                "PLAYER_SLUG": "luka-doncic",
                "POSITION": "Forward-Guard",
                "ROSTERSTATUS": "Active",
                "SCHOOL": "Real Madrid",
                "SEASONS": [
                    "12018",
                    "22018",
                    "12019",
                    "22019",
                    "32019",
                    "42019",
                    "12020",
                    "22020",
                    "32020",
                    "42020",
                    "12021",
                    "22021",
                    "32021",
                    "42021",
                    "12022",
                    "22022",
                    "32022",
                    "12023",
                    "22023"
                ],
                "SEASON_EXP": 5,
                "TEAM_ABBREVIATION": "DAL",
                "TEAM_CITY": "Dallas",
                "TEAM_CODE": "mavericks",
                "TEAM_ID": 1610612742,
                "TEAM_NAME": "Mavericks",
                "TO_YEAR": 2023,
                "WEIGHT": "230"
            },
            "rotowireBio": "Luka Doncic was born in Ljubljana, Slovenia, to Mirjam Poterbin and Sasha Doncic. His father played pro basketball in Slovenia while his godfather, Radoslav Nesterovic, played 12 seasons in the NBA and won a title with the San Antonio Spurs in 2005. Luka began playing basketball at age eight with the youth teams of Olimpija. He practiced often with Olimpija's under-14 team, but due to league rules, could not play with the squad. Instead, he played for the club's under-12 selection team. When he was only 13, Doncic signed a five-year contract with Real Madrid. He immediately began playing for the under-16 team, earning the MVP award during the under-16 Spain Championship. In the championship game, he scored 25 points in victory. The following year, Doncic moved up to Real Madrid's under-18 team and reserve team. He continued to shine, winning the MVP award at the under-18 Next Generation Tournament and claiming a championship. At 16 years, two months and two days of age, he made his professional debut, becoming the youngest player to ever play for Real Madrid. A little over three years later, Doncic became an NBA player when he was selected in the 2018 NBA Draft. He has shown an interest for charitable giving throughout his brief career, donating game-worn sneakers to raise money for meaningful causes on more than one occasion. Learn more about Doncic by following him on Twitter (@luka7doncic) and on Instagram (@lukadoncic). Luka Doncic played three seasons for the EuroLeague's Real Madrid squad before joining the Mavericks in 2018. As a 16-year-old, he appeared in 51 EuroLeague and ACB games for Real Madrid, coming off the bench to average 4.3 points, 2.5 rebounds and 1.8 assists in over 12 minutes per game during the 2015-16 season. During his second year with Real Madrid, Doncic started 26 of 77 EuroLeague and ACB games, helping the squad to a fourth-place EuroLeague finish.  He led the team in scoring in four of 36 EuroLeague contests. Doncic's EuroLeague career peaked in 2017-18, a season in which he led Real Madrid to their 10th EuroLeague Championship. He averaged 16.0 points, 4.8 boards and 4.3 assists over 33 EuroLeague contests.  After Real Madrid defeated Fenerbahce Dogus in the EuroLeague finals, Doncic was named both EuroLeague Final Four MVP and EuroLeague MVP.  At 18, he was the youngest EuroLeague player to win the MVP award.",
            "stats": {
                "AST": 9.6,
                "PIE": 0.201,
                "PLAYER_ID": 1629029,
                "PLAYER_NAME": "Luka Doncic",
                "PTS": 34.7,
                "REB": 8.6,
                "TimeFrame": "2023-24"
            }
        }
    """.trimIndent()
        .toPlayer()

@OptIn(ExperimentalSerializationApi::class)
fun String.toPlayer(): Player = Json.decodeFromString<Player>(this)
