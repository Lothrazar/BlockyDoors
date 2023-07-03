#!/bin/bash

echo "Useage: ./_.sh <dest>"



dest=$1
newblock="door_${dest}"

original="stone"
seed="door_${original}"

modid="blockydoors"
folder="src/main/resources/assets/${modid}"
folderdata="src/main/resources/data/${modid}"


cp "${folder}"/blockstates/"${seed}".json "${folder}"/blockstates/"${newblock}".json
sed -i -e "s/${original}/${dest}/g" "${folder}"/blockstates/"${newblock}".json

cp "${folder}"/models/item/"${seed}".json "${folder}"/models/item/"${newblock}".json
sed -i -e "s/${original}/${dest}/g" "${folder}"/models/item/"${newblock}".json


cp "${folder}"/models/block/"${seed}"_bottom_left_open.json "${folder}"/models/block/"${newblock}"_bottom_left_open.json
cp "${folder}"/models/block/"${seed}"_bottom_left.json "${folder}"/models/block/"${newblock}"_bottom_left.json
cp "${folder}"/models/block/"${seed}"_bottom_right_open.json "${folder}"/models/block/"${newblock}"_bottom_right_open.json
cp "${folder}"/models/block/"${seed}"_bottom_right.json "${folder}"/models/block/"${newblock}"_bottom_right.json

cp "${folder}"/models/block/"${seed}"_top_left_open.json "${folder}"/models/block/"${newblock}"_top_left_open.json
cp "${folder}"/models/block/"${seed}"_top_left.json "${folder}"/models/block/"${newblock}"_top_left.json
cp "${folder}"/models/block/"${seed}"_top_right_open.json "${folder}"/models/block/"${newblock}"_top_right_open.json
cp "${folder}"/models/block/"${seed}"_top_right.json "${folder}"/models/block/"${newblock}"_top_right.json


sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_bottom_left_open.json
sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_bottom_left.json
sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_bottom_right_open.json
sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_bottom_right.json

sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_top_left_open.json
sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_top_left.json
sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_top_right_open.json
sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${newblock}"_top_right.json

cp "${folderdata}"/loot_tables/blocks/${seed}.json "${folderdata}"/loot_tables/blocks/"${newblock}".json
cp "${folderdata}"/recipes/${seed}.json "${folderdata}"/recipes/"${newblock}".json


sed -i -e "s/${original}/${dest}/g" "${folderdata}"/recipes/"${newblock}".json
sed -i -e "s/${seed}/${newblock}/g" "${folderdata}"/recipes/"${newblock}".json
sed -i -e "s/${seed}/${newblock}/g" "${folderdata}"/loot_tables/blocks/"${newblock}".json



    
echo "  \"block.blockydoors.${newblock}\":\"${newblock} Door\", "
echo "  \"blockydoors:${newblock}\",   "
echo "   to the blocks/doors.json data tag"

