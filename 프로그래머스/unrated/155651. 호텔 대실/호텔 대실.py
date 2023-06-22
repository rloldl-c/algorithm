def time_converter(s):
    h, m = map(int, s.split(":"))
    return h * 60 + m


def solution(book_time):
    answer = 0
    room = []

    for time in book_time:
        time[0] = time_converter(time[0])
        time[1] = time_converter(time[1])

    book_time = sorted(book_time, key=lambda x: x[0])

    for i in range(len(book_time)):
        if not room:
            room.append(book_time[i])
        else:
            for j in range(len(room)):
                if room[j][1] + 10 <= book_time[i][0]:
                    room[j] = book_time[i]
                    break
            else:
                room.append(book_time[i])

        answer = max(answer, len(room))

    return answer