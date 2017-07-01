SET FOREIGN_KEY_CHECKS=0;
truncate table item;
truncate table item_category;
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO item_category(`id`,`name`)VALUES
(1,'vegetable'),
(2,'herb'),
(3,'house'),
(4,'succulent'),
(5,'fruit');


INSERT INTO `item`(`id`,`item_category_id`,`name`,`description`) VALUES
(1,1,"Tomato","Kamatis is a hairy annual herb, typically growing 1 to 3 meters in height, with ascending or spreading hairy and branched stems. Stem is weak, often sprawling over the ground or vines over other plants. Leaves are pinnate and alternate, oblong-ovate, 10 to 40 centimeters long. Leaflets are irregular and toothed or lobed. Inflorescence is racemose or cymose, 5 to 8 centimeters long, and few flowered. Flowers are yellow, 1 to 1.5 centimeters long. Fruit is variable in shape; in the wild and naturalized forms it is rounded or pear-shaped; 1 to 1.5 centimeters in diameter; in the commonly cultivated form, the fruit is rounded and compressed, lobed, 4 to 10 centimeters wide, red when ripe, smooth, fleshy, juicy, subacid, containing numerous seeds."),
(2,1,"Carrot","Carrot is an erect, vegetable herb, growing 30 to 60 centimeters in height, with 2 to 3 pinnate leaves, the ultimate leaflet being oblong-lanceolate or linear. Flowers are small, white, or yellow, borne in compound umbels. Fruit is small, ellipsoid, dorsally compressed, bristled and ribbed. The tap root is robust, sometimes swollen, fleshy, and yellow or orange-colored."),
(3,1,"Potato","Patatas is a perennial herb with rough, pinnate leaves. Flowers are rather large, white or purple, star-shaped, and borne on compound inflorescences, 3 to 4 centimeters in diameter. Roots grow round and edible fleshy tubers"),
(4,1,"Spinach","New Zealand spinach is an annual, spreading herb growing to 50 centimeters high. . Leaves are succulent, triangular to oval in shape, 3 to 6 centimeters long and 2.5 to 4.5 centimeters wide. The flowers are small and yellowish green."),
(5,1,"Eggplant","Talong is a coarse, usually branched, prickly or unarmed, erect, half-woody plant, growing to a height of 0.5 to 1 meter. Leaves are ovate to oblong-ovate, 10 to 25 centimeters long, stellate-hairy beneath, and irregularly or shallowly lobed at the margins. Flowers are axillary, purplish, about 2.5 centimeters long. Fruit is fleshy, smooth, purple, up to 25 centimeters long, extremely variable in shape, round, oblong, or cylindric-oblong.");

INSERT INTO `item`(`id`,`item_category_id`,`name`,`description`) VALUES
(6,2,"Basil","Balanoy is an erect, branched branched, smooth, somewhat hairy, and very aromatic undershrub, growing 0.5 to 1.5 meters high. Leaves are simple, opposite, ovate to oblong-ovate, entire or slightly toothed, with acute tips and glandular spots on the lower surface. Flowers are pink or purplish and borne in racemes which are 8 to 15 centimeters long. Calyx of the individual flower or floret is strongly reflexed, the upper lobe round, the lower two narrowly lanceolate and acuminate, and the lateral ones ovate. Corolla bilabiate, exerted, and upper lip broader, subequally 4-fid, the lower lip entire. Petals pink or purplish, stamens exserted. Fruits are nutlets, smooth or somewhat rugose."),
(7,2,"Laurel","Laurel is an erect or spreading, more or less branched, herbaceous or half-woody plant, 1.5 meters or less in height. Leaves are ovate to oblong-ovate, 8 to 13 centimeters long, smooth, slightly drooping, with entire, undulate or wavy margins, with a pointed or blunt tip and a pointed base. Spikes are 15 to 30 centimeters long. Calyx is tubular, 8 to 10 millimeters long, covered with stalked, sticky glands. Corolla is bright red, tube is slender, about 2.5 centimeters long, and the spreading limb, about 3 centimeters in diameter."),
(8,2,"Indian Borage","Trichodesma indicum is an erect, spreading, branched, annual herb, about 50 centimeters in height. Leaves are stalkless, opposite, lanceolate, 2 to 8 centimeters long, pointed at the tip, and heart-shaped at the base; the upper surfaces clothed with stiff hairs arising from circular tubercles, the lower surfaces less densely villous. Flowers occur singly in the axils of the leaves. Calyx is green, hairy, and 1 to 1.3 centimeters long, with pointed lobes. Corolla is pale blue, with the limb about 1.5 centimeters in diameter, and the lobes pointed. Fruit is ellipsoid, and enclosed by the calyx. Nutlets are about 5 millimeters long, and rough on the inner surface."),
(9,2,"Celery","Kintsay is an erect herb, seldom growing over 30 centimeters in height. The Chinese variety has short stems. Leaves are pinnate, with large, deeply-lobed segments, on long petioles. Peduncles are short, less than 1 centimeter in length, and borne opposite the leaves. Flowers are borne in umbels, very small, and greenish white. Fruit is very small, with narrow ridges."),
(10,2,"Chives","Kuchai is a kind of leek, ranked-scented, green, growing 20 to 40 centimeters high. Bulbs are small, white and clustered. Leaves are green, grasslike, narrowly linear, flattish, 15 to 30 centimeters long, 3 to 6 millimeters wide. Umbel has a few to many white flowers. The perianth is bell-shaped. Fruits are on pedicels of 2 to 3 centimeters long, obovoid, 3-lobed, 5 to 7 millimeters in diameter. Seeds are black, depressed, globose or reniform, 2.5 to 3 milimeters in diameter. In the Philippines, the plant seldom flowers.");

INSERT INTO `item`(`id`,`item_category_id`,`name`,`description`) VALUES
(11,3,"African Violet","African violet care information guide: Belonging to the Saintpaulia Genus with many species. Growing conditions, possible problems, pictures and description. "),
(12,3,"Barberton Daisy","A flowering pot plant displaying striking flowers."),
(13,3,"Belladonna Lily","Also known as the naked lady because of the bare flower stalks that appear without leaves. "),
(14,3,"Blushing Bromeliad","An interesting species from the bromeliad family which produces a red center within the rosette of leaves. "),
(15,3,"Beach Spider Lily","This amazing bulb based plant beach spider lily enjoys environments that are downright aquatic and easy to maintain. "),

INSERT INTO `item`(`id`,`item_category_id`,`name`,`description`) VALUES
(16,4,"Echeveria","The crown jewels of the rosette-forming succulents, easy-care Echeveria come in a rainbow of colors and can be easily found at nurseries. Some of our top picks include rose-colored ‘Afterglow’, frilly-edged ‘Blue Curls’, deep purple ‘Black Prince’, and pearly lavender ‘Perle von Nurnberg’. All Echeveria perform splendidly in containers and grow well in garden beds in mild-summer areas."),
(17,4,"Sedum (Stonecrop)","These primarily low-growing succulents are excellent planted as ground covers, tucked between rocks in walls, and planted to trail over the edges of containers. Chartreuse Sedum ‘Angelina’ is particularly useful as a bright complement to grey-green Echeveria."),
(18,4,"Aeonium","The fleshy rosettes of aeonium come in a rainbow of colors—from lemon yellow (Aeonium ‘Sunburst’) to deep maroon (Aeonium ‘Zwartkp’)—and take little water to thrive. With their bold forms and upright growth habit, they’re a natural choice for accent plants in garden beds and containers."),
(19,4,"Agave","From towering tequila-producing blue agave (Agave tequiliana) to ornamental artichoke agave (Agave parriya), there’s a reason to find a place for one of these spiny specimens in any garden. Their architectural shapes are particularly stunning silhouetted against walls and hedges. Plant spine-free Agave attenuatta along pathways to avoid being poked."),
(20,4,"Dudleya","The fleshy rosettes of most Dudleya varieties are covered by a chalky powder giving them the appearance of being freshly dusted with powdered sugar. To keep the powder from washing off, grow varieties such as Dudleya birttonii in areas sheltered from heavy rain such as on sunny covered patios or on bright windowsills.");

INSERT INTO `item`(`id`,`item_category_id`,`name`,`description`) VALUES
(21,5,"Avocado","Avocado is a subtropical plant that can resist some frost, but not freezing. There are many varieties, but the one most commonly found in the grocery store is the Hass avocado. Technically, avocado is a berry. The fruit only ripens after it has been removed from the tree."),
(22,5,"Banana","Bananas are a tropical herb that only grow in areas that do not receive a frost like South Florida and Hawaii. The banana most often sold on grocery store shelves is the Cavendish variety. Many varieties are available for the home and greenhouse grower, including dwarf trees."),
(23,5,"Mango","Mangoes are a tropical tree that only grow in areas that are frost-free all year. These trees can get quite large, up to 100 feet tall, but are very tough plants that produce fruit from even young trees."),
(24,5,"Pear","One of the best-known pear varieties is the Bartlett pear, which is often seen on the grocery store shelves. When planting pear trees, be sure to research the variety first. Not all pear trees will be able to cross-pollinate each other. This varies depending on the specific variety."),
(25,5,"Peach","Peaches are another longtime favorite because of their sweet, juicy flesh. The trees need a winter chill to set fruit and properly grow new leaves and branches. This varies depending on the variety of peach being grown.");



SET FOREIGN_KEY_CHECKS=0;
truncate table wiki;
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO `wiki`(`id`,`item_id`,`title`) VALUES
(1,1,"How to plant a tomato");

