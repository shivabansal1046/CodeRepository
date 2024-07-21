import tabula
import pandas as pd
import os

files = os.listdir("pdfs/")
counter = 0
files_arr = []
for file in files:
    dfs = tabula.read_pdf(f'pdfs/{file}', pages = 'all')
    files_arr = files_arr + dfs
    counter += 1
print("Total File processed:", counter)
conv_df_arr = []

for page in files_arr:
    columns = page.columns
    ids = list(filter(lambda x: 'Srlno' in x, columns))
    marks = list(filter(lambda x: 'Marks' in x, columns))

    col_pairs = zip(ids, marks)
    
    for id, mark in col_pairs:
        tmp_df = page[[id, mark]]
        tmp_df.columns = ['id', 'marks']
        conv_df_arr.append(tmp_df)
print(len(conv_df_arr))
merged_df = pd.concat(conv_df_arr, axis=0)
#print(merged_df)

merged_df.to_excel("merged_scored_complete.xlsx")


