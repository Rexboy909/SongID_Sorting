# SongID_Sorting
Sorting song data.

## Overview
Sort and filter song data by SongID for quick lookup and statistics.

### Observed Performance (Two Dataset Sizes)
- Dataset sizes tested: n = 1,000 and n = 10,000
- Environment: Same machine, single-run averages (actual results below)

Search:
- Linear (Sequential) Search:
  - n=1k: ~0.34 ms
  - n=10k: ~1.01 ms
  - Observation: Time grows roughly proportionally with n.
- Binary Search (on sorted data):
  - n=1k: ~0.0036 ms
  - n=10k: ~0.0045 ms
  - Observation: Very small increase as n grows.

Sort:
- Bubble Sort (quadratic baseline):
  - n=1k: ~9.46 ms (by playcount), ~14.54 ms (by date)
  - n=10k: ~131.54 ms (by playcount), ~799.29 ms (by date)
  - Observation: Rapid growth; scales poorly beyond small n.
- Merge/Quick/Heap Sort (O(n log n)):
  - n=1k: Merge ~0.4 ms, Quick ~0.78 ms, Heap ~0.60 ms (by playcount)
  - n=10k: Merge ~6.15 ms, Quick ~3.67 ms, Heap ~2.07 ms (by playcount)
  - Observation: Gradual increase; scales predictably.

### Big-O Mapping
- Linear Search: O(n)
- Binary Search: O(log n) (requires sorted data)
- Bubble Sort: O(n²)
- Merge/Heap/Quick Sort: O(n log n)

### Evidence Table

| Algorithm     | Observed Behavior            | Big-O     | Evidence / Notes                               |
|---------------|------------------------------|-----------|-----------------------------------------------|
| Linear Search | Time increased steadily      | O(n)      | 1k: 0.34 ms; 10k: 0.1.01 ms                     |
| Binary Search | Small increase               | O(log n)  | 1k: 0.0036 ms; 10k: 0.0045 ms                   |
| Bubble Sort   | Rapid increase               | O(n²)     | 1k: 9.46 ms; 10k: 131.54 ms (by playcount)       |
| Merge/Quick/Heap Sort | Gradual increase     | O(n log n)| 1k: 0.4–0.78 ms; 10k: 2.06–6.15 ms (by playcount)|

### Recommendations (Scenario-Based)
- Which search algorithm is best?
  - Use Binary Search when data is sorted or indexable; otherwise Linear Search for one-off lookups on small datasets.
- Which sort algorithm is best?
  - Use O(n log n) sorts (Merge/Heap/Quick). Avoid Bubble Sort except for teaching or tiny arrays.
- Justification:
  - Observations match Big-O: binary search scales with log n; n log n sorting remains practical up to large n, while n² explodes.

### Reflection
- What surprised you most?
  - The near-constant cost of binary search compared to linear search even at 10k.
- Tradeoffs between simplicity vs performance:
  - Linear search is simpler and OK for very small n; binary search requires sorted data or extra preprocessing.
- Dataset size impact:
  - As n grows, differences magnify: n² becomes infeasible even at 10k; n log n remains manageable.
- Real-world changes:
  - Maintain indexes (e.g., hash maps or B-trees) for searches; for sorting large files, use external/parallel sorting and streaming.
