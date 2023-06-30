def time_convert(s):
    h, m = map(int, s.split(":"))
    return h * 60 + m


def sharp_convert(note):
    sharp = {"C#": "H", "D#": "I", "F#": "J", "G#": "K", "A#": "L"}
    for j in range(len(note)-1):
        if j > len(note) - 1 or j + 1 > len(note) - 1:
            return note

        tmp = note[j]+note[j+1]
        if tmp in sharp:
            note = note.replace(tmp, sharp[tmp])
            
    return note


def solution(m, musicinfos):
    answer = ''
    musics = []
    m = sharp_convert(m)
    
    for i in range(len(musicinfos)):
        start, end, name, note = musicinfos[i].split(",")
        time = time_convert(end) - time_convert(start)
        note = sharp_convert(note)
                
        if time < len(note):
            playing = note[:time]
        else:
            playing = note * (time//len(note)) + note[:(time%len(note))]

        if m in playing:
            musics.append([time, name])
            
    if not musics:
        answer = "(None)"
    else:
        max_playing = max(musics, key=lambda x: x[0])[0]
        
        for time, name in musics:
            if time == max_playing:
                answer = name
                break
        
    return answer