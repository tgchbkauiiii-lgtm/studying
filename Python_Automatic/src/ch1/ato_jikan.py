# %%
from datetime import datetime
sleep_t = datetime(2023,1,1,22,0,0)
wakeup_t = datetime(2023,1,2,8,30,0)
delta = wakeup_t - sleep_t
print(type(delta))
sec = delta.seconds
hours = sec / (60 * 60)
print(f'あと{hours}時間です')
# %%
