# %%
from datetime import datetime
yoteibi = datetime(2025,4,13)
now = datetime.now()
delta = yoteibi - now
print('あと'+str(delta.days+1)+'日です')
# %%
